import {makeProject} from '@motion-canvas/core';

import timeline from './scenes/timeline?scene';
import example from './scenes/box-and-arrow-example?scene';

export default makeProject({
  scenes: [timeline,example],
});
