package br.oo.alexandria.library;

import java.util.*;

public class Loan {
    
    // mudar para letras minúsculas
    private final int ID_USER;
    private final int ID_EXEMPLARY;
    private final Date LENT_DATE;
    private Date devolutionDate;

    public Loan(int idUser, int idExemplary, Date lentDate) {
        this.ID_USER = idUser;
        this.ID_EXEMPLARY = idExemplary;
        this.LENT_DATE = lentDate;
    }
    
    // -------------- Getters --------------

    public int getIdUser() {
        return this.ID_USER;
    }

    public int getIdExemplary() {
        return this.ID_EXEMPLARY;
    }

    public Date getLentDate() {
        return this.LENT_DATE;
    }

    public Date getDevolutionDate() {
        return this.devolutionDate;
    }

    // -------------- Setters --------------

    public void setDevolutionDate(Date devolutionDate) throws Exception {
        if (devolutionDate.compareTo(this.LENT_DATE) >= 0) {
            this.devolutionDate = devolutionDate;
        } else {
            throw new Exception("A data de devolução precisa ser mais recente que a data de empréstimo");
        }
    }
}
