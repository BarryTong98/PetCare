package au.edu.sydney.web.service;

import au.edu.sydney.base.Result;

/**
 * @author Chris
 * @date 2021-09-14 22:02
 * @description
 */
public interface ServiceService {

    Result getServiceById(int id);

    Result getServiceBySpid(int spid);
}
