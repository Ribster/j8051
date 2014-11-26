/*
 * Copyright (c) 2014, Dries007
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 *  Redistributions of source code must retain the above copyright notice, this
 *   list of conditions and the following disclaimer.
 *
 *  Redistributions in binary form must reproduce the above copyright notice,
 *   this list of conditions and the following disclaimer in the documentation
 *   and/or other materials provided with the distribution.
 *
 *  Neither the name of the project nor the names of its
 *   contributors may be used to endorse or promote products derived from
 *   this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 */

package net.dries007.j8051.compiler;

import net.dries007.j8051.compiler.exceptions.CompileException;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.regex.Matcher;

/**
 * @author Dries007
 */
public class Directives
{
    private Directives()
    {
    }

    static void findConstants(LinkedList<Line> lines, HashMap<String, Symbol> constants) throws CompileException
    {
        for (Line line : lines)
        {
            if (line.done) continue;
            String code = line.code;
            for (Symbol.Type type : Symbol.Type.values())
            {
                Matcher matcher = type.pattern.matcher(code);
                while (matcher.find())
                {
                    if (constants.containsKey(matcher.group(1))) throw new CompileException("Constant defined more then once: " + line);
                    constants.put(matcher.group(1), new Symbol(type, matcher));
                    code = matcher.replaceFirst("").trim();
                    line.done = code.isEmpty();
                    if (line.done) break;
                }
                if (line.done) break;
            }
        }
    }
}