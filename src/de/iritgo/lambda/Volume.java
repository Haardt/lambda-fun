package de.iritgo.lambda;

public interface Volume
{
    int volume ();

    static Volume volume(int volume) {return () -> volume; }

    default Volume turnUp() { return volume(volume() + 1);}

    default Volume turnDown() { return volume(volume() - 1);}
}
