package com.nickrankin.ca1.CA1.Web.Services.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nickrankin.ca1.CA1.Web.Services.helpers.FormType;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "tax_returns")
public class Return {

    private @Id @GeneratedValue Long id;

    @JsonProperty("form")
    private String formType;

    @Column(name = "return_year")
    private int returnYear;

    private Double taxPayed;

    @JoinColumn(name = "user_id", nullable = false)
    // Need JSON property here, otherwise ForeignKey be null: https://stackoverflow.com/questions/72618745/foreign-key-returns-nulls-with-json
    @JsonProperty("userId")
    private Long  userId;

    public Return() {}
    public Return(Long userId, String formType, int returnYear, Double taxPayed) {
        this.userId = userId;
        this.formType = formType;
        this.returnYear = returnYear;
        this.taxPayed = taxPayed;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getId() {
        return id;
    }

    public String getForm() {
        return formType;
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
        return returnYear == aReturn.returnYear && Objects.equals(id, aReturn.id) && formType == aReturn.formType && Objects.equals(taxPayed, aReturn.taxPayed) && Objects.equals(userId, aReturn.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, formType, returnYear, taxPayed, userId);
    }

    @Override
    public String toString() {
        return "Return{" +
                "id=" + id +
                ", form=" + formType +
                ", returnYear=" + returnYear +
                ", taxPayed=" + taxPayed +
                ", userId=" + userId +
                '}';
    }
}
