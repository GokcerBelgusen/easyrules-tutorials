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

import static org.easyrules.core.JmxRulesEngineBuilder.aNewJmxRulesEngine;

import java.util.Scanner;
import org.easyrules.api.JmxRulesEngine;
import org.easyrules.samples.shop.Person;
import org.easyrules.samples.shop.part1.AlcoholRule;

public class Launcher {

    public static void main(String[] args) {

        //create a person instance
        Person tom = new Person("Tom", 14);
        System.out.println("Tom: Hi! can I have some Vodka please?");

        //create a Jmx rules engine
        JmxRulesEngine rulesEngine = aNewJmxRulesEngine()
                .named("shop rules engine")
                .build();

        //register rules
        rulesEngine.registerJmxRule(new AgeRule(tom));
        rulesEngine.registerRule(new AlcoholRule(tom));

        //fire rules
        rulesEngine.fireRules();

        // Update adult age via a JMX client.
        Scanner scanner = new Scanner(System.in);
        System.out.println("******************************************************");
        System.out.println("Change adult age via a JMX client and then press enter");
        scanner.nextLine();

        System.out.println("*****************************************");
        System.out.println("Re fire rules after updating adult age...");
        System.out.println("******************************************");

        rulesEngine.fireRules();
    }

}
