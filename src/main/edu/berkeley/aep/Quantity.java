package edu.berkeley.aep;

// Understands an amount in a given unit
public class Quantity {

    private final int size;
    private final Units units;

    public Quantity(int size, Units units) {
        this.size = size;
        this.units = units;
    }

    @Override
    public int hashCode() {
        return size;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Quantity)) return false;
        Quantity other = (Quantity) obj;
        return equals(other);
    }

    private boolean equals(Quantity other) {
        if (!units.convertsTo(other.units)) return false;
        return size == other.convertTo(units).size;
    }

    private Quantity convertTo(Units otherUnits) {
        return new Quantity(units.convertTo(size, otherUnits), units);
    }

    public Quantity add(Quantity quantity) {
        if (!quantity.units.convertsTo(units)) {
            throw new RuntimeException("Cannot add " + quantity.units + " to " + units);
        }
        return new Quantity(quantity.convertTo(units).size + size, units);
    }
}