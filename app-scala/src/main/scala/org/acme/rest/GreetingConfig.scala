package org.acme.rest

import io.smallrye.config.{ConfigMapping, WithName}

@ConfigMapping(prefix = "greeting")
trait GreetingConfig {

  @WithName("message")
  def message: String

}
