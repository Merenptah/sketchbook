import {Icon, Layout, Line, Rect, Txt, Node} from '@motion-canvas/2d/lib/components';
import {makeScene2D} from '@motion-canvas/2d/lib/scenes';
import {createRef} from "@motion-canvas/core/lib/utils";
import {Orientation, OrthogonalConnection} from "../components/OrthogonalConnection";
import {createSignal} from "@motion-canvas/core/lib/signals";
import { Cylinder } from '../components/Cylinder';
import {all} from "@motion-canvas/core/lib/flow";

export default makeScene2D(function* (view) {
    const first = createRef<Rect>();
    const second = createRef<Rect>();
    const opacityOne = createSignal(0)
    const opacityTwo = createSignal(0)
    const splitOne = createRef<Txt>();
    const splitOneArrow = createRef<OrthogonalConnection>();
    const splitTwo = createRef<Txt>();
    const splitTwoArrow = createRef<OrthogonalConnection>();
    const threeArrow = createRef<OrthogonalConnection>();
    const hedging = createRef<Rect>();
    const refLayout = createRef<Layout>();

    view.add(
        <>
            <Cylinder position={[0,-400]} width={300} height={200} cylinderHeight={30} stroke={'black'}  lineWidth={5}></Cylinder>
            <Node ref={refLayout}>
                <Layout ref={refLayout} direction={'column'} gap={80} alignItems={'start'} layout>
                    <Rect ref={first}>
                        <Layout direction={'row'} gap={40} alignItems={'center'}>
                            <Icon icon={"iconamoon:number-1-circle-fill"} width={150} height={150} color={"#a10909"}></Icon>
                            <Txt fontSize={80}>first reason</Txt>
                        </Layout>
                    </Rect>
                    <Rect ref={second} opacity={0}>
                        <Layout direction={'row'} gap={40} alignItems={'center'}>
                            <Icon icon={"iconamoon:number-2-circle-fill"} width={150} height={150} color={"#a10909"}></Icon>
                            <Txt fontSize={80}>second reason</Txt>
                        </Layout>
                    </Rect>
                </Layout>
                <Txt ref={splitOne} opacity={opacityOne} position={[first().position.x() + 700, first().position.y() - 100]}>explanation one</Txt>
                <Txt ref={splitTwo} opacity={opacityTwo} position={[first().position.x() + 700, first().position.y() + 100]}>explanation two</Txt>
                <OrthogonalConnection
                    ref={splitOneArrow}
                    start={0.2}
                    from={first().right}
                    fromOrientation={Orientation.horizontal}
                    to={splitOne().left}
                    toOrientation={Orientation.horizontal}
                    end={0.9}
                    endArrow
                    opacity={opacityOne}
                    stroke={'black'}
                    lineWidth={5}></OrthogonalConnection>
                <OrthogonalConnection
                    ref={splitTwoArrow}
                    start={0.2}
                    from={first().right}
                    fromOrientation={Orientation.horizontal}
                    to={splitTwo().left}
                    toOrientation={Orientation.horizontal}
                    end={0.9}
                    endArrow
                    opacity={opacityTwo}
                    stroke={'black'}
                    lineWidth={5}></OrthogonalConnection>
                <Rect
                    ref={hedging}
                    opacity={1}
                    position={[second().position.x() + 700, second().position.y() + 300]}
                    layout
                >
                    <Layout direction={'row'} gap={40} alignItems={'center'}>
                        <Txt fontSize={80}>base</Txt>
                        <Layout direction={'column'} gap={40} alignItems={'center'}>
                            <Line radius={240} points={[[0,100],[100,100], [200,0]]} stroke={"black"} endArrow lineWidth={5}>
                                <Line marginTop={40} points={[[0,0], [200,0]]} lineDash={[10,10]} stroke={"red"} lineWidth={5}>
                                </Line>
                            </Line>
                            <Line radius={240} points={[[0,100], [100,100], [200,200]]} stroke={"black"} endArrow lineWidth={5}>
                                <Line marginTop={20} points={[[0,0], [200,0]]} lineDash={[10,10]} stroke={"red"} lineWidth={5}>
                                </Line>
                            </Line>
                        </Layout>
                    </Layout>
                </Rect>
                <OrthogonalConnection
                    ref={threeArrow}
                    start={0.05}
                    from={second().bottom}
                    fromOrientation={Orientation.vertical}
                    to={hedging().left}
                    toOrientation={Orientation.horizontal}
                    end={0.9}
                    endArrow
                    opacity={opacityTwo}
                    stroke={'black'}
                    lineWidth={5}></OrthogonalConnection>
            </Node>
        </>
    );

    yield* opacityOne(1, 2);
    yield* opacityTwo(1, 2);
    yield* second().opacity(1, 4);
    yield* all(
        refLayout().scale(0.5, 5),
        refLayout().x(-300, 5),
    );
});
