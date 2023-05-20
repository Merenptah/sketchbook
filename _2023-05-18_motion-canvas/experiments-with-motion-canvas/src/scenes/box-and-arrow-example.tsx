import {makeScene2D} from '@motion-canvas/2d/lib/scenes';
import {Layout, Node, Rect, Txt} from '@motion-canvas/2d/lib/components';
import {createRef} from "@motion-canvas/core/lib/utils";
import {createSignal} from "@motion-canvas/core/lib/signals";
import {Orientation, OrthogonalConnection} from "../components/OrthogonalConnection";
import {Label} from "../components/Label";
import {PossibleVector2, SimpleVector2Signal, Vector2} from "@motion-canvas/core/lib/types";

function* c4Component(parent: Node, name: string, description: string, position: Vector2) {
    const ref = createRef<Rect>();

    yield parent.add(
        <Rect
            ref={ref}
            position={position}
            padding={50}
            radius={40}
            lineWidth={4}
            textAlign={'center'}
            stroke={'#1168BD'}
            fill={'#1168BD'}
            smoothCorners
            layout
        >
            <Layout direction={'column'} gap={20}>
                <Txt
                    fontSize={45}
                    fill={'white'}
                    fontWeight={1000}
                >
                    {name}
                </Txt>
                <Txt
                    fontSize={40}
                    fill={'white'}
                >{description}</Txt>
            </Layout>
        </Rect>
    );

    return ref;
}

function* connection(
    parent: Node,
    label: string,
    labelAt: number,
    from: SimpleVector2Signal<Rect>,
    fromOrientation: Orientation,
    to: SimpleVector2Signal<Rect>,
    toOrientation: Orientation
) {
    const ref = createRef<OrthogonalConnection>();

    yield parent.add(
        <OrthogonalConnection
            ref={ref}
            from={from}
            to={to}
            endArrow
            stroke={'darkgrey'}
            lineDash={[30, 10]}
            lineWidth={5}
            label={label}
            fromOrientation={fromOrientation}
            toOrientation={toOrientation}>
            <Label
                position={() => ref().getPointAtPercentage(labelAt).position}
                text={label}
            />
        </OrthogonalConnection>
    );

    return ref;
}

export default makeScene2D(function* (view) {
    const boxRef = yield* c4Component(
        view,
        "Test application",
        `This is a test
        application`,
        new Vector2(-600, -300));

    const otherBoxRef = yield* c4Component(
        view,
        "Other application",
        `This is another test
        application`,
        new Vector2(0, 0));

    const orthArrow = yield* connection(
        view,
        "This is a label",
        0.15,
        boxRef().bottom,
        Orientation.vertical,
        otherBoxRef().left,
        Orientation.horizontal
    );

    const percentage = createSignal(.99);

    yield* percentage(0.15, 2);
    yield* otherBoxRef().position([500, 500], 3);
});
