package services;

import data.MailAddress;
import data.Signature;

/**
 * External Service for sending mails
 */
public interface MailerService {
    void send(MailAddress address, Signature signature);
}
