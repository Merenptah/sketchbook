import {makeScene2D} from '@motion-canvas/2d/lib/scenes';
import {Layout, Rect, Txt} from "@motion-canvas/2d/lib/components";
import {createRef} from "@motion-canvas/core/lib/utils";

export default makeScene2D(function* (view) {
    const refRect1 = createRef<Rect>();
    const refRect2 = createRef<Rect>();
    const refRect3 = createRef<Rect>();

    view.add(<>
            <Rect
                ref={refRect1}
                position={[0, 360]}
                width={200}
                height={200}
                fill={'white'}
                stroke={'black'}
                lineWidth={10}
            />,
            <Rect
                ref={refRect2}
                position={[0, 360]}
                width={100}
                height={150}
                fill={'white'}
                stroke={'black'}
                lineWidth={10}
                zIndex={10}>

                <Layout direction={'column'} gap={10} layout>
                    <Txt fontSize={30}>Test </Txt>
                    <Txt fontSize={30}>Test 2 </Txt>
                </Layout>


            </Rect>,
            <Rect
                ref={refRect3}
                position={[360, 800]}
                width={200}
                height={200}
                fill={'white'}
                stroke={'black'}
                lineWidth={10}
            />,
        </>
    );

    yield* refRect2().position([360, 800], 3);
});
