# Blocc_Challenge
This is a Switch(Widget) which was created for an internship challenge. It combines two View Classes:
A view class named switch and a view class named thumb. Both are combined in the MainActivity.class layout --> main_activity.xml.
In the switch class I connected two circles and a rectangle to make a pill sized form horizontally. 
The Circle is merged out of two Arcs which I squeeze in the animation to look like a line. However, at the end of the 
circle -> line animation a drawn line appears(changed alpha of the view) very smoothly to make the ellipse look like a line.
However, you can't really see that unless you put the animation duration up to 5000. This quick action happens in the last duration
of the animation. This secures a smooth and seemless travel between a line and a circle. 
