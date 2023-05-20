import {makeScene2D} from '@motion-canvas/2d/lib/scenes';
import {Layout, Node, Rect, Txt} from '@motion-canvas/2d/lib/components';
import {Orientation, OrthogonalConnection} from "../components/OrthogonalConnection";
import {Label} from "../components/Label";
import {SimpleVector2Signal, Vector2} from "@motion-canvas/core/lib/types";
import {beginSlide, createRef, Reference} from '@motion-canvas/core/lib/utils';
import {easeInOutCubic, tween} from "@motion-canvas/core/lib/tweening";
import {Color} from "@motion-canvas/core/lib/types/Color";
import {all} from "@motion-canvas/core/lib/flow";


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
): Generator<Node, [Reference<OrthogonalConnection>, Reference<Label>]> {
    const ref = createRef<OrthogonalConnection>();
    const labelRef = createRef<Label>();

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
                ref={labelRef}
                text={label}
                textColor={'darkgrey'}
            />
        </OrthogonalConnection>
    );

    return [ref, labelRef];
}

export default makeScene2D(function* (view) {
    const title = createRef<Txt>();
    view.add(<Txt ref={title} position={[0, -450]}/>);

    title().text('FIRST SLIDE');
    yield* beginSlide("first slide")
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

    const orthArrowRefs = yield* connection(
        view,
        "This is a label",
        0.15,
        boxRef().bottom,
        Orientation.vertical,
        otherBoxRef().left,
        Orientation.horizontal
    );

    title().text('SECOND SLIDE');
    yield* beginSlide('second slide');
    yield* otherBoxRef().position([500, 300], 3);


    title().text('Third SLIDE');
    yield* beginSlide('third slide');
    const newAppRef = yield* c4Component(
        view,
        "Other application",
        `This is another test
        application`,
        new Vector2(500, 300));
    const arrowOldToNewRefs = yield* connection(
        view,
        "This is another label",
        0.5,
        boxRef().bottom,
        Orientation.vertical,
        newAppRef().left,
        Orientation.horizontal
    );
    yield* newAppRef().position([500, 0], 4);
    yield* all(
        tween(4, value => {
            otherBoxRef().fill(Color.lerp('#1168BD', '#8AA5BE', easeInOutCubic(value)));
            otherBoxRef().stroke(Color.lerp('#1168BD', '#8AA5BE', easeInOutCubic(value)));
            orthArrowRefs[0]().stroke(Color.lerp('darkgrey', 'white', easeInOutCubic(value)));
            orthArrowRefs[1]().textColor(Color.lerp('darkgrey', 'white', easeInOutCubic(value)).name());
        })
    );
});
