package com.usa.misiontic.MasterClass3.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "message")
public class Message implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMessage;
    private String messageText;

    @ManyToOne
    @JoinColumn(name = "id")
    @JsonIgnoreProperties({"messages","reservations"})
    private Partyroom partyroom;

    @ManyToOne
    @JoinColumn(name = "idClient")
    @JsonIgnoreProperties({"messages","reservations"})
    private Client client;


/*
    @ManyToOne
    @JoinColumn(name = "idPartyroom")
    @JsonIgnoreProperties({"messages","reservations"})
    private Partyroom partyroom;


    @ManyToOne
    @JoinColumn(name = "idClient")
    @JsonIgnoreProperties({"messages","reservations"})
    private Client client;


    @ManyToOne
    @JoinColumn(name = "idClient")
    @JsonIgnoreProperties({"messages","reservations"})
    private Client client;

*/

    /*
    @ManyToOne
    @JoinColumn(name = "clientId")
    @JsonIgnoreProperties({"messages","reservations"})
    private Category category;

     */

    /////////////////////////////////////////////////////////////////////////

    public Partyroom getPartyroom() {
        return partyroom;
    }

    public void setPartyroom(Partyroom partyroom) {
        this.partyroom = partyroom;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }


    /////////////////////////////////////////////////////////////////////////

    public Integer getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(Integer idMessage) {
        this.idMessage = idMessage;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }


}
