package redisgroovy

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.connection.RedisConnectionFactory
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.data.redis.serializer.JacksonJsonRedisSerializer
import org.springframework.data.redis.serializer.StringRedisSerializer
import org.springframework.stereotype.Component

@Component
@Configuration
class RedisConfigImpl implements RedisConfig {

    RedisTemplate template

    @Bean
    def createTemplate(RedisConnectionFactory connectionFactory) {
        RedisTemplate tmpl = new RedisTemplate<String, Object>()
        tmpl.setConnectionFactory(connectionFactory)
        template = tmpl
        tmpl
    }

    def setEntityType(Class<?> entityType) {
        template.setKeySerializer(new StringRedisSerializer())
        template.setValueSerializer(new JacksonJsonRedisSerializer<>(entityType))
    }

    def setEntity(String key, Object entity) {
        setEntityType(entity.class)
        template.opsForValue().set(key, entity)
    }

    def getEntity(Class<?> entityType, String key) {
        setEntityType(entityType)
        template.opsForValue().get(key)
    }

    def getTemplate() {
        template
    }
}