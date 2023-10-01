function tailingNonClosedBrackets(string) {
    let stack = []
    let brackets = {
        ")": "(",
        "]": "["
    }

    const reversedString = string.split("").reverse().join("");
    for (let i=0; i < reversedString.length; i++) {
        let char = stack[stack.length - 1]
        if (Object.keys(brackets).includes(reversedString[i])) {
            stack.push(reversedString[i])
        } else if (reversedString[i] === brackets[char]) {
            stack.pop()
        }
    }

    return stack
}

function parseSingleInlineFieldValue(tail) {
    let isArray = /^\s*-/.test(tail);
    if (isArray) {
        let arrayLines = tail.split("\n");
        let result = [];
        let arrayBreakIndex = arrayLines.findIndex(l => !l.startsWith("-"));
        if (arrayBreakIndex === -1) {
            arrayBreakIndex = arrayLines.length + 1;
        }
        const firstArray = arrayLines.slice(0, arrayBreakIndex);
        firstArray
            .forEach(l => {
                let value = l.substring(l.indexOf("-") + 1).trim();
                result.push(value);
            });
        return result;
    }

    let fullLine = /^(.*)/.exec(tail)[0];
    let unclosed_brackets = tailingNonClosedBrackets(fullLine);
    for (let i=0; i < unclosed_brackets.length; i++ ) {
        if (fullLine.endsWith(unclosed_brackets[i])) {
            fullLine = fullLine.slice(0, -1);
        } else {
            break;
        }
    }

    return fullLine;
}

function parseInlineFields(content) {
    const properties = [];

    const findInlineFields = /([a-zA-Z-_\\.0-9]+)::((.|\n|\r)*?)(?=(?:[a-zA-Z-_\\.0-9]+::|$))/g;
    let match;
    while ((match = findInlineFields.exec(content)) !== null) {
        const key = match[1].trim();
        const tail = match[2].trim();

        const value = parseSingleInlineFieldValue(tail);
        properties.push({ key, content: value });
    }

    return properties;
}

module.exports = {parseInlineFields}