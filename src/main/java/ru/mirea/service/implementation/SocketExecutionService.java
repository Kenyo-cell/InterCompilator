package ru.mirea.service.implementation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.mirea.exception.ExecutionTransferException;
import ru.mirea.service.ContainerDispatcherService;
import ru.mirea.service.IExecutionService;
import ru.mirea.service.container.ContainerDefinitionObject;
import ru.mirea.transfer.ExecutionContextTransferObject;
import ru.mirea.transfer.ExecutionResultTransferObject;

import java.io.*;
import java.net.Socket;
import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
public class SocketExecutionService extends IExecutionService {
    private final ContainerDispatcherService containerDispatcherService;

    @Override
    public byte[] execute(String language, InputStream source, InputStream input) throws ExecutionTransferException {
        ContainerDefinitionObject container = containerDispatcherService.getFreeContainer(language);
        try (
                Socket socket = new Socket("localhost", container.port());
                ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream())
        ){
            ExecutionContextTransferObject executionContext = new ExecutionContextTransferObject(
                    source.readAllBytes(),
                    input.readAllBytes()
            );

            socket.setSoTimeout(Math.toIntExact(TimeUnit.SECONDS.toMillis(TIMEOUT)));

            oos.writeObject(executionContext);
            oos.flush();

            ExecutionResultTransferObject returnedContext = (ExecutionResultTransferObject) ois.readObject();
            return returnedContext.result();
        } catch (IOException | ClassNotFoundException e) {
            throw new ExecutionTransferException("", e);
        }
    }
}
