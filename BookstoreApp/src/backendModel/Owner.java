package backendModel;

public class Owner extends Account{
    
    private static Owner instance;
    
    public Owner() {
        super("admin", "admin");     
    }
    
    public Owner getInstance()
    {
        if(instance == null)
        {
            instance = new Owner();
        }
        return instance;
    }
    
    @Override
    public String getUserName()
    {
        return this.username;
    }
    
    @Override
    public String getPassword()
    {
        return password;
    }
    
    @Override
    public void setUserName(String u)
    {
        System.err.println("Error, no access");
    }
    
    @Override
    public void setPassword(String p)
    {
       System.err.println("Error, no access");
    }

    @Override
    public int getPoints() {
        System.err.println("No points handled");
        return -1;
    }

    @Override
    public void setPoints(int p) {
        System.err.println("No points handled");
    }

    @Override
    public void setIsChecked(boolean isChecked) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean getIsChecked() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
