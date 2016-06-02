//
//  cgShape.java
//
//  20155
//
//  Class that includes routines for tessellating a number of basic shapes.
//
//  Students are to supply their implementations for the functions in
//  this file using the function "addTriangle()" to do the tessellation.
//
//  Contributor:  Swetha Kannan Iyer
//

import java.awt.*;
import java.nio.*;
import java.awt.event.*;
import javax.media.opengl.*;
import javax.media.opengl.awt.GLCanvas;
import java.io.*;

public class cgShape extends simpleShape
{
    ///
    // constructor
    ///
    public cgShape()
    {
  
    }

    ///
    // makeCube - Create a unit cube, centered at the origin, with a given
    // number of subdivisions in each direction on each face.
    //
    // @param subdivision - number of equal subdivisons to be made in each
    //        direction along each face
    //
    // Can only use calls to addTriangle()
    ///
    public void makeCube (int subdivisions)
    {
        if( subdivisions < 1 )
            subdivisions = 1;
        float val=0.5f;
        
        double n=(double)(1.0/subdivisions);

    	   for(double x=-0.5;x<0.5-0.000001;x=x+(1.0/subdivisions)){
        	   for (double y=-0.5;y<0.5-0.000001;y=y+(1.0/subdivisions)){
        		   double z=0.5;                             //for the z =constant +ve plane
        		   addTriangle((float)(x),(float)(y+n),(float)z,(float)(x),(float)y,(float)z,(float)(x+n),(float)(y+n),(float)z);
        	        addTriangle((float)(x),(float)y,(float)z,(float)(x+n),(float)(y),(float)z,(float)(x+n),(float)(y+n),(float)z);
        	   }
    	   }
    	  
    	   for(double y=-0.5;y<0.5-0.000001;y=y+(1.0/subdivisions)){
        	   for (double z=-0.5;z<0.5-0.000001;z=z+(1.0/subdivisions)){
        		   double x=-0.5;                             //for the x =constant -ve plane
        		   addTriangle((float)x,(float)(y+n),(float)(z+n),(float)(x),(float)(y+n),(float)(z),(float)(x),(float)(y),(float)z);
        	        addTriangle((float)(x),(float)y,(float)(z+n),(float)(x),(float)(y+n),(float)(z+n),(float)(x),(float)(y),(float)z);
        	   }
    	   }
    	   for(double y=-0.5;y<0.5-0.000001;y=y+(1.0/subdivisions)){
        	   for (double z=-0.5;z<0.5-0.000001;z=z+(1.0/subdivisions)){
        		   double x=0.5;                             //for the x =constant +ve plane
        		   addTriangle((float)x,(float)(y+n),(float)(z+n),(float)(x),(float)y,(float)(z+n),(float)(x),(float)(y+n),(float)z);
        	        addTriangle((float)(x),(float)y,(float)(z+n),(float)(x),(float)(y),(float)z,(float)(x),(float)(y+n),(float)z);
        	   }
    	   }
    	   for(double x=-0.5;x<0.5-0.000001;x=x+(1.0/subdivisions)){
        	   for (double z=-0.5;z<0.5-0.000001;z=z+(1.0/subdivisions)){
        		   double y=0.5;                             //for the y =constant +ve plane
        		   addTriangle((float)x,(float)(y),(float)(z),(float)(x),(float)y,(float)(z+n),(float)(x+n),(float)(y),(float)z);
        	        addTriangle((float)(x),(float)y,(float)(z+n),(float)(x+n),(float)(y),(float)(z+n),(float)(x+n),(float)(y),(float)z);
        	   }
    	   }
    	   for(double x=-0.5;x<0.5-0.000001;x=x+(1.0/subdivisions)){
        	   for (double y=-0.5;y<0.5-0.000001;y=y+(1.0/subdivisions)){
        		   double z=-0.5;                             //for the z =constant -ve plane
        		   addTriangle((float)x,(float)(y),(float)z,(float)(x),(float)(y+n),(float)z,(float)(x+n),(float)(y),(float)z);
        	        addTriangle((float)(x),(float)(y+n),(float)z,(float)(x+n),(float)(y+n),(float)z,(float)(x+n),(float)(y),(float)z);
        	   }
    	   }
  	   
        	   for(double x=-0.5;x<0.5-0.000001;x=x+(1.0/subdivisions)){
            	   for (double z=-0.5;z<0.5-0.000001;z=z+(1.0/subdivisions)){
            		   double y=-0.5;                             //for the y =constant -ve plane
            		   addTriangle((float)x,(float)(y),(float)(z+n),(float)(x),(float)y,(float)(z),(float)(x+n),(float)(y),(float)(z+n));
            	        addTriangle((float)(x),(float)y,(float)(z),(float)(x+n),(float)(y),(float)z,(float)(x+n),(float)(y),(float)(z+n));
            	   }
        	   }
    
       }
      

    

    ///
    // makeCylinder - Create polygons for a cylinder with unit height, centered
    // at the origin, with separate number of radial subdivisions and height
    // subdivisions.
    //
    // @param radius - Radius of the base of the cylinder
    // @param radialDivision - number of subdivisions on the radial base
    // @param heightDivisions - number of subdivisions along the height
    //
    // Can only use calls to addTriangle()
    ///
    public void makeCylinder (float radius, int radialDivisions, int heightDivisions)
    {
        if( radialDivisions < 3 )
            radialDivisions = 3;

        if( heightDivisions < 1 )
            heightDivisions = 1;
        double dy=1.0/heightDivisions;
        
        double alpha=360.0/radialDivisions;
        double radians = Math.toRadians(alpha/2);
        double sine=Math.sin(radians);
        double tangent=Math.tan(radians);
       
        double z=-radius;
        double theta=((2*Math.PI)/radialDivisions);
        for(int i=1;i<=radialDivisions;i++){//body

        	double x1=0.5*Math.cos((180-(i*theta)));
        	
        	double y1=0.5;
        	double z1=0.5*Math.sin((180-(i*theta)));

        	double x2=0.5*Math.cos((180-(((i+1)%radialDivisions)*theta)));
        	double y2=0.5;
        	double z2=0.5*Math.sin((180-(((i+1)%radialDivisions)*theta)));
        	
        	double x3=0;
        	double y3=0.5;
        	double z3=0;
        	
        	addTriangle((float)x1,(float)y1,(float)z1,(float)x2,(float)y2,(float)z2,(float)x3,(float)y3,(float)z3);//top surface
        	double x4=0.5*Math.cos(((i*theta)));
        	
        	double y4=-0.5;
        	double z4=0.5*Math.sin(((i*theta)));
        	
        	double x5=0.5*Math.cos(((((i+1)%radialDivisions)*theta)));
        	double y5=-0.5;
        	double z5=0.5*Math.sin(((((i+1)%radialDivisions)*theta)));
        	
        	double x6=0;
        	double y6=-0.5;
        	double z6=0;
        	
        	
        	for(double y=1;y<=heightDivisions;y++){
        		addTriangle((float)x2,(float)y2,(float)z2,(float)x1,(float)y1,(float)z1,(float)x2,(float)(y2-dy),(float)z2);//front
            	addTriangle((float)x2,(float)(y2-dy),(float)z2,(float)x1,(float)y1,(float)z1,(float)x1,(float)(y1-dy),(float)z1);
           	y1=y1-dy;
           	y2=y2-dy;
        		
        	}
        	
        
        	addTriangle((float)x2,(float)y2,(float)z2,(float)x1,(float)y1,(float)z1,(float)x6,(float)y6,(float)z6);//bottom surface
        	
        	
        	
        }
       
    }

    ///
    // makeCone - Create polygons for a cone with unit height, centered at the
    // origin, with separate number of radial subdivisions and height
    // subdivisions.
    //
    // @param radius - Radius of the base of the cone
    // @param radialDivision - number of subdivisions on the radial base
    // @param heightDivisions - number of subdivisions along the height
    //
    // Can only use calls to addTriangle()
    ///
    public void makeCone (float radius, int radialDivisions, int heightDivisions)
    {
        if( radialDivisions < 3 )
            radialDivisions = 3;

        if( heightDivisions < 1 )
            heightDivisions = 1;
        
double dy=1.0/heightDivisions;
        
        double alpha=360.0/radialDivisions;
        double radians = Math.toRadians(alpha/2);
        double sine=Math.sin(radians);
        double tangent=Math.tan(radians);
     
        double z=-radius;
        double theta=((2*Math.PI)/radialDivisions);
        for(int i=1;i<=radialDivisions;i++){

        	double x1=0.5*Math.cos((180-(i*theta)));
        	
        	double y1=0.5;
        	double z1=0.5*Math.sin((180-(i*theta)));

        	double x2=0.5*Math.cos((180-(((i+1)%radialDivisions)*theta)));
        	double y2=0.5;
        	double z2=0.5*Math.sin((180-(((i+1)%radialDivisions)*theta)));
        	
        	double x3=0;
        	double y3=0.5;
        	double z3=0;
        	
        	addTriangle((float)x1,(float)y1,(float)z1,(float)x2,(float)y2,(float)z2,(float)x3,(float)y3,(float)z3);//base
        	double x4=0.5*Math.cos(((i*theta)));
        	
        	double y4=-0.5;
        	double z4=0.5*Math.sin(((i*theta)));
        	
        	double x5=0.5*Math.cos(((((i+1)%radialDivisions)*theta)));
        	double y5=-0.5;
        	double z5=0.5*Math.sin(((((i+1)%radialDivisions)*theta)));
        
        	double x6=0;
        	double y6=-0.5;
        	double z6=0;
        	double diffx1 = x1/heightDivisions;
        	double diffx2 = x2/heightDivisions;
        	double diffz1 = z1/heightDivisions;
        	double diffz2 = z2/heightDivisions;
        	
        
        	for(double y=1;y<=heightDivisions;y++){
        		addTriangle((float)x2,(float)y2,(float)z2,(float)x1,(float)y1,(float)z1,(float)(x2-diffx2),(float)(y2-dy),(float)(z2-diffz2));//front
            	addTriangle((float)(x2-diffx2),(float)(y2-dy),(float)(z2-diffz2),(float)x1,(float)y1,(float)z1,(float)(x1-diffx1),(float)(y1-dy),(float)(z1-diffz1));
           	y1=y1-dy;
           	y2=y2-dy;
           	x1=x1-diffx1;
           	x2=x2-diffx2;
           	z1=z1-diffz1;
           	z2=z2-diffz2;
           	
        	}	
        }
        
        }
    

    ///
    // makeSphere - Create sphere of a given radius, centered at the origin,
    // using spherical coordinates with separate number of thetha and
    // phi subdivisions.
    //
    // @param radius - Radius of the sphere
    // @param slides - number of subdivisions in the theta direction
    // @param stacks - Number of subdivisions in the phi direction.
    //
    // Can only use calls to addTriangle
    ///
    public void makeSphere (float radius, int slices, int stacks)
    {
	// IF USING RECURSIVE SUBDIVISION, MODIFY THIS TO USE
	// A MINIMUM OF 1 AND A MAXIMUM OF 5 FOR 'slices'

        if( slices < 3 )
            slices = 3;

        if( stacks < 3 )
            stacks = 3;
        for(float a=0;a<slices;a++)
        	for(float b=0;b<stacks;b++)
        	{
        		double th1=(a*Math.PI*2)/slices;
        		double th2=((a+1)*Math.PI*2)/slices;
        		double phi1=(b*Math.PI)/stacks;
        		double phi2=((b+1)*Math.PI)/stacks;
        		
        		double x1,x2,x3,x4,y1,y2,y3,y4,z1,z2,z3,z4;
        		x1=radius * Math.cos(th1) * Math.sin(phi1);
        		y1=radius * Math.sin(th1) * Math.sin(phi1);
        		z1=radius * Math.cos(phi1);
        		
        		x2=radius * Math.cos(th2) * Math.sin(phi1);
        		y2=radius * Math.sin(th2) * Math.sin(phi1);
        		z2=radius * Math.cos(phi1);
        		
        		x3=radius * Math.cos(th2) * Math.sin(phi2);
        		y3=radius * Math.sin(th2) * Math.sin(phi2);
        		z3=radius * Math.cos(phi2);
        		
        		x4=radius * Math.cos(th1) * Math.sin(phi2);
        		y4=radius * Math.sin(th1) * Math.sin(phi2);
        		z4=radius * Math.cos(phi2);
        		
        		addTriangle((float)x2, (float)y2, (float)z2, (float)x1, (float)y1, (float)z1, (float)x3, (float)y3, (float)z3);
        		addTriangle((float)x3, (float)y3, (float)z3, (float)x1, (float)y1, (float)z1, (float)x4, (float)y4, (float)z4);
        		
        		
        	}

        // YOUR IMPLEMENTATION HERE
    }

}
