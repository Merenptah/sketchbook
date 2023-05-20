import {Circle, Curve, Node, NodeProps, Rect, Shape, Txt} from '@motion-canvas/2d/lib/components';
import {easeInOutCubic, tween} from '@motion-canvas/core/lib/tweening';
import {Color, ColorSignal, PossibleColor,} from '@motion-canvas/core/lib/types/Color';
import {colorSignal, initial, signal} from '@motion-canvas/2d/lib/decorators';
import {createSignal, SignalValue, SimpleSignal, unwrap,} from '@motion-canvas/core/lib/signals';
import {createRef, Reference} from '@motion-canvas/core/lib/utils';
import {all} from '@motion-canvas/core/lib/flow';

export interface LabelProps extends NodeProps {
    text?: SignalValue<string>;
}

export class Label extends Node {
    @initial("")
    @signal()
    public declare readonly text: SimpleSignal<string, this>;

    public constructor(props?: LabelProps) {
        super({
            ...props,
        });

        this.add(
            <Rect
                fill={'white'}
                smoothCorners
                radius={40}
                padding={20}
                fontSize={40}
                layout
            >
                <Txt
                    fill={'darkgrey'}
                    text={this.text}
                    textWrap
                />
            </Rect>
        );
    }

}