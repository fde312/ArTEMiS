package de.tum.in.www1.artemis.service.compass.strategy;

import de.tum.in.www1.artemis.service.compass.assessment.Context;
import de.tum.in.www1.artemis.service.compass.umlmodel.UMLClass;
import de.tum.in.www1.artemis.service.compass.umlmodel.UMLElement;
import de.tum.in.www1.artemis.service.compass.umlmodel.UMLModel;
import de.tum.in.www1.artemis.service.compass.umlmodel.UMLRelation;

import java.util.HashSet;

@SuppressWarnings("unused")
public class ClassContext {

    public static Context getNoContext(UMLClass umlClass, UMLModel model) {
        return Context.NO_CONTEXT;
    }

    /**
     *
     * @return Context including the relations connected to the UML class and all children of the class (attributes + methods)
     */
    public static Context getStrictContext(UMLClass umlClass, UMLModel model) {
        HashSet<Integer> relations = new HashSet<>();
        for (UMLRelation umlRelation : model.getRelationList()) {
            if (umlRelation.getSource().equals(umlClass) || umlRelation.getTarget().equals(umlClass)) {
                relations.add(umlRelation.getElementID());
            }
        }
        for (UMLElement element: umlClass.getAttributeList()) {
            relations.add(element.getElementID());
        }
        for (UMLElement element: umlClass.getMethodList()) {
            relations.add(element.getElementID());
        }
        if (relations.isEmpty()) {
            return Context.NO_CONTEXT;
        }
        return new Context(relations);
    }

    /**
     *
     * @return Context including the relations connected to the UML class
     */
    public static Context getWeakContext(UMLClass umlClass, UMLModel model) {
        HashSet<Integer> relations = new HashSet<>();
        for (UMLRelation umlRelation : model.getRelationList()) {
            if (umlRelation.getSource().equals(umlClass) || umlRelation.getTarget().equals(umlClass)) {
                relations.add(umlRelation.getElementID());
            }
        }
        if (relations.isEmpty()) {
            return Context.NO_CONTEXT;
        }
        return new Context(relations);
    }
}
