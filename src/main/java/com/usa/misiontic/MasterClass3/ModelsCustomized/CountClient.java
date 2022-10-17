package com.usa.misiontic.MasterClass3.ModelsCustomized;

import com.usa.misiontic.MasterClass3.entities.Client;
import net.bytebuddy.asm.Advice;

public class CountClient {
    private Long total;
    private Client client;

    public CountClient(Long total, Client client){
        this.total = total;
        this.client = client;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
