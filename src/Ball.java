public class Ball
{
    int size;
    int xSpeed;
    int ySpeed;
    int xLocation;
    int yLocation;

    public Ball(int xLocation, int yLocation)
    {
        this.size = 10;
        this.xSpeed = 1;
        this.ySpeed = 1;
        this.xLocation = xLocation;
        this.yLocation = yLocation;
    }

    public void setSize(int size)
    {
        this.size = size;
    }

    public int getSize()
    {
        return this.size;
    }

    public void setxSpeed()
    {
        if (this.xLocation + this.size > 1000 || this.xLocation < 0)
        {
            this.xSpeed = - (this.xSpeed + 1);
        }

        if (this.xSpeed >= 20 || this.xSpeed <= -20)
        {
            this.xSpeed = this.xSpeed / 20;
        }
    }

    public int getxSpeed()
    {
        return this.xSpeed;
    }

    public void setySpeed()
    {
        if (this.yLocation + this.size > 700 || this.yLocation < 0)
        {
            this.ySpeed = - (this.ySpeed + 1);
        }

        if (this.ySpeed >= 20 || this.ySpeed <= -20)
        {
            this.ySpeed = this.ySpeed / 20;
        }
    }

    public int getySpeed()
    {
        return this.ySpeed;
    }

    public void setxLocation()
    {
        this.xLocation += getxSpeed();
    }

    public void setyLocation()
    {
        this.yLocation += getySpeed();
    }

    public int getxLocation()
    {
        return this.xLocation;
    }

    public int getyLocation()
    {
        return this.yLocation;
    }
}
