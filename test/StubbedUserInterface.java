class StubbedUserInterface extends UserInterface
{
    public StubbedUserInterface()
    {
        super(null, null);
    }

    @Override
    public String readString(String prompt)
    {
        return "Inception";
    }

    @Override
    public int readInt(String prompt)
    {
        return 2010;
    }

    @Override
    public boolean readBoolean(String prompt)
    {
        return true;
    }
}
