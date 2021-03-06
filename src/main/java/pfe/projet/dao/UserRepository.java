package pfe.projet.dao;
import pfe.projet.entities.User;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, String> {
@Query("select u from User u where u.login like :x and u.motpasse like :y")
	public Page<User>chercher(@Param("x") String mc,@Param("x") String mp,Pageable pageable);
@Query("select u from User u where u.login like :x and u.motpasse like :y")
public Page<User>chercheUser(@Param("x") String mc,@Param("x") String mp);

}
