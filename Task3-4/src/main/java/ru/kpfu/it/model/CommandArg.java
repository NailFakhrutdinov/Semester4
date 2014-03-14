package ru.kpfu.it.model;


public class CommandArg {
    private Command command;
    private String title;
    private Long id;

    public CommandArg(Command command, String title) throws Exception {
        if (!command.equals(Command.CREATE))
            throw new Exception("Wrong command");

        this.command = command;
        this.title = title;
    }

    public CommandArg(Command command, Long id) throws Exception {
        if (!command.equals(Command.CLOSE) && !command.equals(Command.DELETE))
            throw new Exception("Wrong command");

        this.command = command;
        this.id = id;
    }

    public CommandArg(Command command) throws Exception {
        if (!command.equals(Command.LIST))
            throw new Exception("Wrong command");
        this.command = command;
    }

    public Command getCommand() {
        return command;
    }

    public String getTitle() {
        return title;
    }

    public Long getId() {
        return id;
    }
}
