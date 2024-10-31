package com.transport.app.platform.check.domain.services;

import com.transport.app.platform.check.domain.model.commands.CreateRequestCommand;

public interface RequestCommandService {

    Long handle(CreateRequestCommand command);
    //Optional<Request> handle(UpdateRequestCommand command);
    //void handle(DeleteRequestCommand command);

}
