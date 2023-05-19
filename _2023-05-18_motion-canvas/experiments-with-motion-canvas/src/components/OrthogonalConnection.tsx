import {Curve, CurveProps} from '@motion-canvas/2d/lib/components';
import {initial, signal} from '@motion-canvas/2d/lib/decorators';
import {SignalValue, SimpleSignal,} from '@motion-canvas/core/lib/signals';
import {BBox, PossibleVector2, Vector2, Vector2Signal} from "@motion-canvas/core/lib/types";
import {vector2Signal} from "@motion-canvas/2d/src/decorators";
import {CurveProfile} from "@motion-canvas/2d/src/curves";
import {getPolylineProfile} from "@motion-canvas/2d/lib/curves";

export interface OrthogonalConnectionProps extends CurveProps {
    from?: SignalValue<PossibleVector2>;
    fromOrientation?: SignalValue<Orientation>;
    to?: SignalValue<PossibleVector2>;
    toOrientation?: SignalValue<Orientation>;
}

export enum Orientation {
    horizontal,
    vertical
}
export class OrthogonalConnection extends Curve {
    @vector2Signal('from')
    public declare readonly from: Vector2Signal<this>;

    @initial(Orientation.vertical)
    @signal()
    public declare readonly fromOrientation: SimpleSignal<Orientation, this>

    @vector2Signal('to')
    public declare readonly to: Vector2Signal<this>;

    @initial(Orientation.vertical)
    @signal()
    public declare readonly toOrientation: SimpleSignal<Orientation, this>

    public constructor(props: OrthogonalConnectionProps) {
        super(props);
    }

    protected override childrenBBox() {
        return BBox.fromPoints(...this.pathPoints());
    }

    public override profile(): CurveProfile {
        return getPolylineProfile(this.pathPoints(), 20, false);
    }

    private pathPoints(): Vector2[] {
        let intermediateSegments = [];

        const fromX = this.from().x;
        const fromY = this.from().y;
        const toX = this.to().x;
        const toY = this.to().y;

        if (this.fromOrientation() == Orientation.horizontal) {
            if (this.toOrientation() == Orientation.horizontal) {
                const intermediatePts = [[(fromX + toX)/2, fromY], [(fromX + toX)/2, toY]].map(pt => new Vector2(pt[0], pt[1]));
                intermediateSegments.push(...intermediatePts);
            } else {
                intermediateSegments.push(new Vector2(toX, fromY));
            }
        } else {
            if (this.toOrientation() == Orientation.horizontal) {
                intermediateSegments.push(new Vector2(fromX, toY));
            } else {
                const intermediatePts = [[fromX, (fromY + toY)/2], [toX, (fromY + toY)/2]].map(pt => new Vector2(pt[0], pt[1]));
                intermediateSegments.push(...intermediatePts);
            }
        }

        return [this.from(), ...intermediateSegments, this.to()];
    }
}
