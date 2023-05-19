import {makeProject} from '@motion-canvas/core';

import example from './scenes/box-and-arrow-example?scene';
import switchExample from './scenes/switch-example?scene';

export default makeProject({
  scenes: [example,switchExample],
});
