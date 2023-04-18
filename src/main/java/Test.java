import org.abstractica.javacsg.Geometry3D;
import org.abstractica.javacsg.JavaCSG;
import org.abstractica.javacsg.JavaCSGFactory;

public class Test
{
	public static void main(String[] args)
	{
		/*
		Geometry3D cyl = csg.cylinder3D(40, 10, 360, false);
		Geometry3D cyl2 = csg.cylinder3D(22, 22, 360, true);
		Geometry3D shape3 = csg.difference3D(cyl, cyl2);

		 */

		JavaCSG csg = JavaCSGFactory.createDefault();
		Wheel wheel = new Wheel(25, 15, 360, false);
		Wheel wheelSpare = new Wheel(35, 15, 360, false);
		Chassis chassis = new Chassis(80, 150, 30, false);
		Chassis chassisTop = new Chassis(80, 100, 60, false);
		BoxLights boxLight = new BoxLights(8, 8, 10, false);
		HeadLights headLights = new HeadLights(12, 5, 360, false);
		//HeadLights innerHeadLight = new HeadLights(10, 10, 360, false);

		//Wheel 1
		Geometry3D wheel1 = csg.cylinder3D(wheel.getDiameter(), wheel.getHeight(), wheel.getAr(), wheel.isCenterZ());
		wheel1 = csg.rotate3DY(csg.degrees(90)).transform(wheel1);
		wheel1 = csg.translate3D(15, 0, 12.5).transform(wheel1);

		//Wheel 2
		Geometry3D wheel2 = csg.cylinder3D(wheel.getDiameter(), wheel.getHeight(), wheel.getAr(), wheel.isCenterZ());
		wheel2 = csg.rotate3DY(csg.degrees(90)).transform(wheel2);
		wheel2 = csg.translate3D(15, 100, 12.5).transform(wheel2);

		Geometry3D wheelsLeft = csg.union3D(wheel1, wheel2);

		//Wheel 3
		Geometry3D wheel3 = csg.cylinder3D(wheel.getDiameter(), wheel.getHeight(), wheel.getAr(), wheel.isCenterZ());
		wheel3 = csg.rotate3DY(csg.degrees(90)).transform(wheel3);
		wheel3 = csg.translate3D(-30, 0, 12.5).transform(wheel3);

		//Wheel 4
		Geometry3D wheel4 = csg.cylinder3D(wheel.getDiameter(), wheel.getHeight(), wheel.getAr(), wheel.isCenterZ());
		wheel4 = csg.rotate3DY(csg.degrees(90)).transform(wheel4);
		wheel4 = csg.translate3D(-30, 100, 12.5).transform(wheel4);

		//Wheel unions
		Geometry3D wheelsRight = csg.union3D(wheel3, wheel4);
		Geometry3D wheelsAll = csg.union3D(wheelsLeft, wheelsRight);

		//Spare wheel
		Geometry3D wheel5 = csg.cylinder3D(wheelSpare.getDiameter(), wheelSpare.getHeight(), wheelSpare.getAr(), wheelSpare.isCenterZ());
		wheel5 = csg.rotate3DX(csg.degrees(90)).transform(wheel5);
		wheel5 = csg.translate3D(5, 135, 50).transform(wheel5);

		Geometry3D wheelsAllAndSpare = csg.union3D(wheelsAll, wheel5);
		//Body
		Geometry3D chassis1 = csg.box3D(chassis.getxSize(), chassis.getySize(), chassis.getzSize(), chassis.isCenterZ());
		chassis1 = csg.translate3D(0, 50, 15).transform(chassis1);

		Geometry3D chassis2 = csg.box3D(chassisTop.getxSize(), chassisTop.getySize(), chassisTop.getzSize(), chassisTop.isCenterZ());
		chassis2 = csg.translate3D(0, 75, 30).transform(chassis2);

		Geometry3D chassisBoth = csg.union3D(chassis1, chassis2);

		//Lights
		Geometry3D leftBoxLight = csg.box3D(boxLight.getxSize(), boxLight.getySize(), boxLight.getzSize(), boxLight.isCenterZ());
		leftBoxLight = csg.translate3D(30, -15, 40).transform(leftBoxLight);

		Geometry3D rightBoxLight = csg.box3D(boxLight.getxSize(), boxLight.getySize(), boxLight.getzSize(), boxLight.isCenterZ());
		rightBoxLight = csg.translate3D(-30, -15, 40).transform(rightBoxLight);

		Geometry3D bothBoxLights = csg.union3D(rightBoxLight, leftBoxLight);

		Geometry3D leftHeadLight = csg.cylinder3D(headLights.getDiameter(), headLights.getHeight(), headLights.getAr(), headLights.isCenterZ());
		leftHeadLight = csg.rotate3DX(csg.degrees(90)).transform(leftHeadLight);
		leftHeadLight = csg.translate3D(-30, -22, 35).transform(leftHeadLight);

		Geometry3D rightHeadLight = csg.cylinder3D(headLights.getDiameter(), headLights.getHeight(), headLights.getAr(), headLights.isCenterZ());
		rightHeadLight = csg.rotate3DX(csg.degrees(90)).transform(rightHeadLight);
		rightHeadLight = csg.translate3D(30, -22, 35).transform(rightHeadLight);


		/*
		Geometry3D leftInnerHeadLight = csg.cylinder3D(innerHeadLight.getDiameter(), innerHeadLight.getHeight(), innerHeadLight.getAr(), innerHeadLight.isCenterZ());
		leftInnerHeadLight = csg.rotate3DX(csg.degrees(90)).transform(leftInnerHeadLight);
		leftInnerHeadLight = csg.translate3D(-30, -20, 35).transform(leftInnerHeadLight);
		Geometry3D innerLights = csg.difference3D(leftHeadLight, leftInnerHeadLight);

		// Geometry3D headLightDiff = csg.union3D(innerLights, boxLightsAndHeadlights);
		 */


		Geometry3D bothHeadLights = csg.union3D(leftHeadLight,rightHeadLight);
		Geometry3D boxLightsAndHeadlights = csg.union3D(bothHeadLights, bothBoxLights);

		Geometry3D chassisAndLights = csg.union3D(chassisBoth, boxLightsAndHeadlights);



		Geometry3D result = csg.union3D(wheelsAllAndSpare, chassisAndLights);
		csg.view(result);
	}
}
