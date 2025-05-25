import {makeScene2D} from '@motion-canvas/2d/lib/scenes';
import {createRef} from "@motion-canvas/core/lib/utils";
import {Switch} from "../components/Switch";

export default makeScene2D(function* (view) {
    const toggle = createRef<Switch>();

    view.add(
        <>
            <Switch ref={toggle} x={100} y={100} />
        </>
    );

    yield* toggle().toggle(2);
});
