import {makeScene2D} from '@motion-canvas/2d/lib/scenes';
import {Rect, Txt} from '@motion-canvas/2d/lib/components';
import {createRef} from '@motion-canvas/core/lib/utils';
import {all} from '@motion-canvas/core/lib/flow';

export default makeScene2D(function* (view) {
    const myComponent = createRef<Rect>();

    view.add(
        <Rect
            ref={myComponent}
            // try changing these properties:
            x={-300}
            width={240}
            height={240}
            smoothCorners={true}
            cornerSharpness={.8}
            fill="#000000">
            <Rect
                // try changing these properties:
                fill="#00e14d"
                padding={110}>
                <Txt>Dummy Component</Txt>
            </Rect>
        </Rect>
    );

    yield* all(
        myComponent().position.x(300, 1).to(-300, 1),
        myComponent().fill('#e6a700', 1).to('#e13238', 1),
    );
});
