package fr.jkh.iamcore.service.matching;


public interface Match<T> {
	
	
	public boolean match(T firstIdentity, T secondIdentity);

}
