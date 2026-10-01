package edu.odu.cs.cs330.items;

import java.util.Objects;
import java.util.Scanner;

/**
 * This class represents one piece of armour--as found in most video games.
 * This includes boots and helmets.
 *
 * Armour may not be stacked.
 */
@SuppressWarnings({
    "PMD.BeanMembersShouldSerialize",
    "PMD.CloneMethodReturnTypeMustMatchClassName",
    "PMD.CloneThrowsCloneNotSupportedException",
    "PMD.LawOfDemeter",
    "PMD.OnlyOneReturn",
    "PMD.ProperCloneImplementation",
    "PMD.MethodArgumentCouldBeFinal",
    "PMD.LocalVariableCouldBeFinal"
})
public class Armour extends Equippable {
    /**
     * The amount of damage that can be negated.
     */
    protected int defense;

    /**
     * Default to a armour with an empty name, zero durability, zero defense,
     * blank material, no modifier a zero modifier level, and a blank element.
     */
    public Armour()
    {
        super();
        this.durability = 0;

        this.defense = 0;
    }

    /**
     * Duplicate a piece of armour.
     *
     * @param src armour to duplicate
     */
    public Armour(Armour src)
    {
        //creates a new armour object that copies the supplied armours traits
        this.name = src.name;
        this.durability = src.durability;
        this.material = src.material;
        this.modifier = src.modifier;
        this.modifierLevel = src.modifierLevel;
        this.element = src.element;
        this.defense = src.defense;
    }

    /**
     * Retrieve armour defense.
     *
     * @return total defense provided
     */
    public int getDefense()
    {
        return this.defense;
    }

    /**
     * Update defense.
     *
     * @param def replacement defense
     */
    public void setDefense(int def)
    {
        this.defense = def;
    }

    /**
     * Read Armour attributes.
     */
    @Override
    public void read(Scanner snr)
    {
        //use the scanner to read through each trait of Armour
        super.name    = snr.next();
        this.material = snr.next();
        this.durability = snr.nextInt();
        this.defense = snr.nextInt();
        this.modifier = snr.next();
        this.modifierLevel = snr.nextInt();
        this.element = snr.next();
        


        // Complete this function.
    }

    /**
     * Clone--i.e., copy--this Armour.
     */
    @Override
    public Item clone()
    {
        Armour cpy = new Armour();

        // Complete this function.
        //copy all of current armour traits into the copy armour and return it
        cpy.name = super.name;
        cpy.durability = this.durability;
        cpy.material = this.material;
        cpy.modifier = this.modifier;
        cpy.modifierLevel = this.modifierLevel;
        cpy.element = this.element;
        cpy.defense = this.defense;


        return cpy;
    }

    /**
     * Check for logical equivalence--based on name, material, modifier, and
     * element.
     *
     * @param rhs object for which a comparison is desired
     */
    @Override
    public boolean equals(Object rhs)
    {
        if (!(rhs instanceof Armour)) {
            return false;
        }

        Armour lhs = this;
        Armour rhsItem = (Armour) rhs;


        // Complete this function.
        //if the armour names, materials, modifiers, or elements are different, return false
        if(!(lhs.name.equals(rhsItem.name))){
            return false;
        }
        else if(!(lhs.material.equals(rhsItem.material))){
            return false;
        }
        else if(!(lhs.modifier.equals(rhsItem.modifier))){
            return false;
        }
        else if(!(lhs.element.equals(rhsItem.element))){
            return false;
        }

        // updated to return that lhs is equals to rhs
        return lhs.name.equals(rhsItem.name);
    }

    /**
     * Generate a hash code by adding the name, material, modifier, and element
     * hash codes.
     */
    @Override
    public int hashCode()
    {
        // Complete this function.
        // Remove the placeholder return
        return Objects.hash(this.name, this.material, this.modifier, this.element);
    }

    /**
     * *Print* one Armour.
     */
    @Override
    public String toString()
    {

        // Complete this function... treat the return as a hint.
        return String.join(
            System.lineSeparator(),
            String.format("  Nme: %s", super.getName()),
            String.format("  Dur: %d", this.getDurability()),
            String.format("  Def: %d", this.getDefense()),
            String.format("  Mtl: %s", this.getMaterial()),
            String.format("  Mdr: %s (Lvl %d)", this.getModifier(), this.getModifierLevel()),
            String.format("  Emt: %s", this.getElement()),
            ""
        );
    }
}




