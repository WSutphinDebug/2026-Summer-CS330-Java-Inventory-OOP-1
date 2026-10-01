package edu.odu.cs.cs330.items;

import java.util.Objects;
import java.util.Scanner;

/**
 * This class represents one Consumable Item--as found in most video games.
 * This includes food.
 *
 * Consumable Items must be stackable.
 */
@SuppressWarnings({
    "PMD.BeanMembersShouldSerialize",
    "PMD.CloneMethodReturnTypeMustMatchClassName",
    "PMD.CloneThrowsCloneNotSupportedException",
    "PMD.LawOfDemeter",
    "PMD.OnlyOneReturn",
    "PMD.ProperCloneImplementation",
    "PMD.MethodArgumentCouldBeFinal",
    "PMD.LocalVariableCouldBeFinal",
    "PMD.BeanMembersShouldSerialize"
})
public class Consumable extends Item {
    /**
     * The effect "buff" or "debuff" that is received when using this item.
     */
    protected String effect;

    /**
     * The number of times this item can be used.
     */
    protected int uses;

    /**
     * Default to a Consumable Item with an empty name, no effect and zero
     * uses.
     */
    public Consumable()
    {
        super("[Placeholder]", true);
        

        this.effect = "";
        this.uses   = 0;
    }

    /**
     * Create a copy of this Consumable.
     *
     * @param src consumable item to duplicate
     */
    public Consumable(Consumable src)
    {
        // Complete this function.
        // Update/replace the call to super
        super(src.name, true);
        
        this.effect = src.effect;
        this.uses = src.uses;
    }

    /**
     * Retrieve the effect.
     *
     * @return the set effect (i.e., buff or debuff)
     */
    public String getEffect()
    {
        return this.effect;
    }

    /**
     * Set a new buff or debuff.
     *
     * @param newEff replacement effect
     */
    public void setEffect(String newEff)
    {
        this.effect = newEff;
    }

    /**
     * Retrieve permitted number of uses.
     *
     * @return number of total uses
     */
    public int getNumberOfUses()
    {
        return this.uses;
    }

    /**
     * Set the number of permitted uses.
     *
     * @param allowed number of allowed uses
     */
    public void setNumberOfUses(int allowed)
    {
        this.uses = allowed;
    }

    /**
     * Read Consumable Item attributes.
     */
    @Override
    public void read(Scanner snr)
    {
        super.name    = snr.next();
        this.effect = snr.next();
        this.uses = snr.nextInt();

        // Complete this function.
    }

    /**
     * Clone--i.e., copy--this Consumable Item.
     */
    @Override
    public Item clone()
    {
        Consumable cpy = new Consumable();

        // Complete this function.
        cpy.name = super.name;
        cpy.stackable = super.stackable;
        cpy.effect = this.effect;
        cpy.uses = this.uses;

        return cpy;
    }

    /**
     * Check for logical equivalence--based on name and effect.
     *
     * @param rhs object for which a comparison is desired
     */
    @Override
    public boolean equals(Object rhs)
    {
       

        if (!(rhs instanceof Consumable)) {
            return false;
        }
        
        Consumable rhsItem = (Consumable) rhs;
        
        //use .equals to compare and confirm that the strings match, not "!=" so to prevent comparing memory addresses and causing consumables to be considered different even with the same name and effect (which prevents stacking)
        if(!(this.name.equals(rhsItem.name))){
            return false;
        }
        else if(!(this.effect.equals(rhsItem.effect))){
            return false;
        }

        

        // Use the provided return as a start/hint
        
        return this.name.equals(rhsItem.name);
    }

    /**
     * Generate a hash code based on name and effect.
     *
     * Add <code>name.hashCode()</code> and <code>effect.hashCode</code>, then
     * return the result.
     */
    @Override
    public int hashCode()
    {
        // Use the provided return as a start/hint
        //return this.name.hashcode
        return Objects.hash(this.name, this.effect);
        
    }

    /**
     * *Print* the Consumable Item.
     */
    @Override
    public String toString()
    {
        // Complete this function... treat the return as a hint.
        return String.join(
            System.lineSeparator(),
            String.format("  Nme: %s", super.getName()),
            String.format("  Eft: %s", this.getEffect()),
            String.format("  Use: %d", this.getNumberOfUses()),
            ""
        );
    }
}
