package com.vidnichuk.isogj.api.service.mail;

import com.vidnichuk.isogj.api.model.TempUser;

public interface EmailService {

    void sendConfirmationEmail(TempUser tempUser);
}
