package edu.nf.hansen.service;

import edu.nf.hansen.service.statistics.Personal;

/**
 * @author Achine
 * @date 2019/12/3
 */
public interface PersonalService {
    Personal getPersonal(String uid);
}