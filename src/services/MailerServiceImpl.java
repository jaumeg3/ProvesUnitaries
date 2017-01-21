package services;

import data.MailAddress;
import data.Signature;

/**
 * Created by jaume on 14/01/17.
 * Mailer Service Implementation
 */
public class MailerServiceImpl implements MailerService{
    private MailAddress address;
    private Signature signature;
    private boolean status = false;

    @Override
    public void send(MailAddress address, Signature signature) {
        this.address = address;
        this.signature = signature;
        boolean status = true;
    }
}