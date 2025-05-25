import {makeScene2D} from '@motion-canvas/2d/lib/scenes';
import {Circle, Line, Ray, Txt} from '@motion-canvas/2d/lib/components';
import {beginSlide, createRef} from '@motion-canvas/core/lib/utils';
import {createSignal} from "@motion-canvas/core/lib/signals";

export default makeScene2D(function* (view) {
    const title = createRef<Txt>();
    const ref = createRef<Line>();
    const percentage = createSignal(0.3);

    view.add(<Txt ref={title} position={[0, -450]}/>);

    title().text('FIRST SLIDE');
    yield* beginSlide("first slide")
    view.add(<>
            <Txt position={[-140, -100]}>
                Milestone 0
            </Txt>
            <Ray
                ref={ref}
                stroke={'#000000'}
                lineWidth={20}
                from={[-300, 0]}
                to={[300, 0]}
            />
            <Circle
                size={64}
                fill={'#f19233'}
                position={() => ref().getPointAtPercentage(percentage()).position}
            />
        </>
    );

    yield* ref().end(-200 ,1).to(300,4);
});
