import {Circle, Node, Rect, Shape, ShapeProps} from '@motion-canvas/2d/lib/components';
import {SignalValue, SimpleSignal} from "@motion-canvas/core/lib/signals";
import {canvasStyleSignal, CanvasStyleSignal, initial, signal} from "@motion-canvas/2d/lib/decorators";

export interface CylinderProps extends ShapeProps {
    cylinderHeight?: SignalValue<number>;
}

export class Cylinder extends Shape {
    @initial(50)
    @signal()
    public declare readonly cylinderHeight: SimpleSignal<number, this>;

    @initial('white')
    @canvasStyleSignal()
    public declare readonly fill: CanvasStyleSignal<this>;

    public constructor(props: CylinderProps) {
        super(props);

        let cylinderLines = <Node>
            <Rect
                width={this.width}
                height={this.height}
                fill={this.fill}
                position={[this.position.x() - this.width() / 2, this.position.y()]}
                stroke={this.stroke}
                lineWidth={this.lineWidth}
            />
            <Circle
                size={this.width()}
                height={this.cylinderHeight()}
                stroke={this.stroke}
                fill={this.fill}
                lineWidth={this.lineWidth}
                startAngle={-12}
                endAngle={192}
                position={[this.position.x() - this.width() / 2, this.position.y() + this.height()/2]}
            />
            <Circle
                size={this.width}
                fill={this.fill}
                height={this.cylinderHeight()}
                position={[this.position.x() - this.width() / 2, this.position.y() - this.height()/2]}
                stroke={this.stroke}
                lineWidth={this.lineWidth}
            />
        </Node>;
        this.view().add(cylinderLines);
    }


}
