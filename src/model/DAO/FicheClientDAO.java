package model.DAO;

import java.sql.ResultSet;

public class FicheClientDAO {

    /**
     * Méthode pour récupération les FichesClients
     * @return ResultSet (la liste des FicheClient)
     **/
    public static ResultSet lesFichesClients()
    {
        String requete = "SELECT e.nomEntreprise as `nomEntreprise`, e.adresseEntreprise as `adresseEntreprise`, CONCAT(V.nomVille,'/', P.nomPays) as `vilePays`, e.telEntreprise as `telEntreprise`, e.email as `emailEntreprise`, CONCAT(u.Nom, ' ', u.Prenom) AS `nomPrenomContact`, l.`contact?` as `etatContact`, l.mailContact as `mailContact`, l.telContact as `telContact` FROM loueur as l JOIN utilisateur as u ON l.idLoueur = u.idUtilisateur JOIN entreprise as e ON l.IdEntreprise = e.idEntreprise JOIN `ville` AS V ON e.idVille = V.idVille JOIN `pays` AS P ON V.idPays = P.idPays";
        return DBConnex.getRS(requete, DBConnex.connexion());
    }

    /**
     * M�tode permettant de r�cup�rer les informations relatives � un utilisateur
     * @param id (id utilidsateur)
     * @return ResultSet
     */
  /*  public static ResultSet uneFicheClient(int id)
    {

        String requete = "SELECT e.nomEntreprise as `nomEntreprise`, e.adresseEntreprise as `adresseEntreprise`, CONCAT(V.nomVille,'/', P.nomPays) as `vilePays`, e.telEntreprise as `telEntreprise`, e.email as `emailEntreprise`, CONCAT(u.Nom, ' ', u.Prenom) AS `nomPrenomContact`, l.mailContact as `mailContact`, l.telContact as `telContact` FROM loueur as l JOIN utilisateur as u ON l.idLoueur = u.idUtilisateur JOIN entreprise as e ON l.IdEntreprise = e.idEntreprise JOIN `ville` AS V ON e.idVille = V.idVille JOIN `pays` AS P ON V.idPays = P.idPays WHERE l.idLoueur = " + id;

        return DBConnex.getRS(requete, DBConnex.connexion());


    }*/
}
