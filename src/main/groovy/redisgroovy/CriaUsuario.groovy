package redisgroovy

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/criausuario")
class CriaUsuario {
    @Autowired
    RedisConfig redis

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    User criaUsuario(@RequestBody User user) {

        redis.setEntity(user.name, user)

        (User) redis.getEntity(User.class, user.name)
    }
}