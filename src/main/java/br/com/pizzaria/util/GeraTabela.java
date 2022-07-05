
package br.com.pizzaria.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Silvio
 */
public class GeraTabela {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.
                           createEntityManagerFactory("pizzaria_pu");        
        emf.close();
    }
}
