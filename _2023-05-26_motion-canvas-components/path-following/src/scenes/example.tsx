import {makeScene2D} from '@motion-canvas/2d/lib/scenes';
import {all, waitFor} from '@motion-canvas/core/lib/flow';
import {createRef} from "@motion-canvas/core/lib/utils";
import {Ray, Rect} from "@motion-canvas/2d/lib/components";
import {clamp} from "@motion-canvas/core/lib/tweening";

export default makeScene2D(function* (view) {
  const refRect1 = createRef<Rect>();
  const refRect2 = createRef<Rect>();
  const refRect3 = createRef<Rect>();
  const refPath1 = createRef<Ray>();
  const refPath2 = createRef<Ray>();
  const refPath3 = createRef<Ray>();

  view.add(
      <>
        <Rect
            ref={refRect1}
            position={[0,180]}
            width={100}
            height={100}
            fill={'white'}
            stroke={'black'}
            lineWidth={5}
        />,
        <Rect
            ref={refRect2}
            position={[180,180]}
            width={100}
            height={100}
            fill={'white'}
            stroke={'black'}
            lineWidth={5}
        />,
        <Rect
            ref={refRect3}
            position={[180,400]}
            width={100}
            height={100}
            fill={'white'}
            stroke={'black'}
            lineWidth={5}
        />,
        <Ray
            ref={refPath1}
            to={refRect1().top}
            end={0}
            stroke={'#8bc34a'}
            lineCap={'round'}
            lineWidth={() => clamp(0, 32, refPath1().arcLength())}
        />,
        <Ray
            ref={refPath2}
            from={refRect1().right}
            to={refRect2().left}
            end={0}
            stroke={'#4a5ec3'}
            lineCap={'round'}
            lineWidth={() => clamp(0, 32, refPath2().arcLength())}
        />,
        <Ray
            ref={refPath3}
            from={refRect2().bottom}
            to={refRect3().top}
            end={0}
            stroke={'#c34a4e'}
            lineCap={'round'}
            lineWidth={() => clamp(0, 32, refPath3().arcLength())}
        />,
      </>

  );


  yield* waitFor(1);
  yield* refPath1().end(1, 1);
  yield* refPath2().end(1, 1);
  yield* refPath3().end(1, 1);
  yield* refRect3().x(300, 2);
});
