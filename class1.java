
public class class1
{

	private double x;

	private double iy;

	class1()
	{
		this.x = 0;
		this.iy = 0;
	}

	class1(double x, double y)
	{
		this.x = x;
		this.iy = y;
	}

	public double met1()
	{
		return this.x;
	}

	public double met2()
	{
		return this.iy;
	}

	public void met3()
	{
		double newx = this.x*this.x-this.iy*this.iy;
		this.iy = 2*this.x*this.iy;
		this.x = newx;
	}

	public double met4()
	{
		return this.x*this.x +this.iy*this.iy;
	}

	public void met5(class1 add)
	{
		this.x += add.met1();
		this.iy += add.met2();
	}

	public void met6()
	{
		this.iy = -this.iy;
	}

	public void met7()
	{
		this.iy = Math.abs(iy);
		this.x = Math.abs(x);
	}
}