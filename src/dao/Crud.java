package dao;

public interface Crud {
	//DB
//	public void connexion();
	//CRUD
	public boolean create(Object obj);
	public Object read(String recherche);
	public boolean update(Object obj);
	public boolean delete(String id);
}
