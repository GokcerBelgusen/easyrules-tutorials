/*
 * The MIT License
 *
 *  Copyright (c) 2016, Mahmoud Ben Hassine (mahmoud.benhassine@icloud.com)
 *
 *  Permission is hereby granted, free of charge, to any person obtaining a copy
 *  of this software and associated documentation files (the "Software"), to deal
 *  in the Software without restriction, including without limitation the rights
 *  to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *  copies of the Software, and to permit persons to whom the Software is
 *  furnished to do so, subject to the following conditions:
 *
 *  The above copyright notice and this permission notice shall be included in
 *  all copies or substantial portions of the Software.
 *
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 *  THE SOFTWARE.
 */
package org.easyrules.samples.shop.part2;

import org.easyrules.core.BasicRule;
import org.easyrules.samples.shop.Person;

public class AgeRule extends BasicRule implements AgeJmxRule {

    private int adultAge = 18;

    private Person person;

    public AgeRule(Person person) {
        super("AgeRule", "Check if person's age is > 18 and marks the person as adult", 1);
        this.person = person;
    }

    @Override
    public boolean evaluate() {
        return person.getAge() > adultAge;
    }

    @Override
    public void execute() {
        person.setAdult(true);
        System.out.printf("Person %s has been marked as adult", person.getName());
        System.out.println();
    }
    
    @Override
    public int getAdultAge() {
        return adultAge;
    }

    @Override
    public void setAdultAge(int adultAge) {
        this.adultAge = adultAge;
    }
}
