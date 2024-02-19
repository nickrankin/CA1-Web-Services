package com.nickrankin.ca1.CA1.Web.Services.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nickrankin.ca1.CA1.Web.Services.helpers.Form;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "tax_returns")
public class Return {

    private @Id @GeneratedValue Long id;

    private Form form;

    @Column(name = "return_year")
    private int returnYear;

    private Double taxPayed;

    @JoinColumn(name = "user_id", nullable = false)
    // Need JSON property here, otherwise ForeignKey be null: https://stackoverflow.com/questions/72618745/foreign-key-returns-nulls-with-json
    @JsonProperty("userId")
    private Long  userId;

    public Return() {}
    public Return(Long userId, Form form, int returnYear, Double taxPayed) {
        this.userId = userId;
        this.form = form;
        this.returnYear = returnYear;
        this.taxPayed = taxPayed;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getId() {
        return id;
    }

    public Form getForm() {
        return form;
    }

    public int getReturnYear() {
        return returnYear;
    }

    public Double getTaxPayed() {
        return taxPayed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Return aReturn = (Return) o;
        return returnYear == aReturn.returnYear && Objects.equals(id, aReturn.id) && form == aReturn.form && Objects.equals(taxPayed, aReturn.taxPayed) && Objects.equals(userId, aReturn.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, form, returnYear, taxPayed, userId);
    }

    @Override
    public String toString() {
        return "Return{" +
                "id=" + id +
                ", form=" + form +
                ", returnYear=" + returnYear +
                ", taxPayed=" + taxPayed +
                ", userId=" + userId +
                '}';
    }
}
