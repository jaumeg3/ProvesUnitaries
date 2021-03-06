package services;

import data.MailAddress;
import data.Signature;

/**
 * Created by jaume on 14/01/17.
 * Mailer Service Implementation
 */
public class MailerServiceImpl implements MailerService{
    public MailAddress address;
    public Signature signature;
    public boolean status = false;

    /**
     * Implement send method.
     * @param address Parameter with the mail address
     * @param signature Parameter with the signature
     */
    @Override
    public void send(MailAddress address, Signature signature) {
        this.address = address;
        this.signature = signature;
        this.status = true;
    }
}