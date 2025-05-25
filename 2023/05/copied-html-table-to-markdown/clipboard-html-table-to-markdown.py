from tkinter import Tk

def format_html_table_to_markdown_table(html_table):
    rows = html_table.split("\n")
    table = []
    for row in rows:
        table.append(row.strip().split("\t"))

    result = ""
    for i, row in enumerate(table, start=1):
        if i == 1:
            header = "|".join(row)
            separator_row = "|".join(list(map(lambda x: '-'*len(x), row)))
            result += "|{}|\n|{}|\n".format(header, separator_row)
        else:
            result += "|{}|".format("|".join(row)) + "\n"

    return result


tk = Tk()
tk.withdraw()
html_table = tk.clipboard_get()

markdown_table = format_html_table_to_markdown_table(html_table)
print(markdown_table)

tk.clipboard_clear()
tk.clipboard_append(markdown_table)
tk.update()
tk.destroy()