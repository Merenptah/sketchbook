import {makeScene2D} from '@motion-canvas/2d/lib/scenes';
import {Circle, Line, Rect, Txt} from '@motion-canvas/2d/lib/components';
import {createRef} from "@motion-canvas/core/lib/utils";
import {createSignal} from "@motion-canvas/core/lib/signals";
import {Orientation, OrthogonalConnection} from "../components/OrthogonalConnection";

export default makeScene2D(function* (view) {
    const box = createRef<Rect>();
    const arrow = createRef<Line>();
    const orthArrow = createRef<OrthogonalConnection>();

    const percentage = createSignal(.99);

    view.add(
        <>
            <Rect
                ref={box}
                x={-600}
                y={-300}
                width={100}
                height={100}
                padding={100}
                radius={40}
                lineWidth={4}
                stroke={'#78A8D8'}
                fill={'#85BBF0'}
                smoothCorners
            >
                <Txt fill={'white'} fontWeight={2}>Test</Txt>
            </Rect>
            <Line
                ref={arrow}
                lineWidth={5}
                stroke={'darkgrey'}
                radius={200}
                start={0.1}
                endOffset={100}
                arrowSize={20}
                startArrow
                lineDash={[30, 10]}
                points={[
                    [-600, -300],
                    [0, -300],
                    [0, 300],
                    [600, 300],
                ]}
            />
            <OrthogonalConnection
                ref={orthArrow}
                from={box().bottom}
                to={[400, 400]}
                endArrow
                stroke={'lightseagreen'}
                lineWidth={5}

                fromOrientation={Orientation.vertical}
                toOrientation={Orientation.horizontal}
            />
            <Circle
                size={32}
                fill={'#f19233'}
                position={() => arrow().getPointAtPercentage(percentage()).position}
            />
        </>
    );

    yield* percentage(0.15, 2);
    yield* orthArrow().to([400, 100], 3);
});
