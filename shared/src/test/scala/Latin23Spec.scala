package edu.holycross.shot.mid.orthography
import org.scalatest.FlatSpec

import edu.holycross.shot.ohco2._
import edu.holycross.shot.cite._


class Latin23Spec extends FlatSpec {

  "The Latin23 object implementing MidOrthography" should "have token categories" in {
      val expectedTypes = Vector(PraenomenToken, PunctuationToken, LexicalToken, NumericToken)
      assert(expectedTypes == Latin23.tokenCategories)
  }

  it should "generate a new tokenized corpus" in {
    val urn = CtsUrn("urn:cts:omar:stoa0179.stoa001.omar:1.1.1")
    val txt = "iam primum omnium satis constat Troia capta in ceteros saevitum esse Troianos; duobus, Aeneae Antenorique, et vetusti iure hospitii et quia pacis reddendaeque Helenae semper auctores fuerunt, omne ius belli Achivos abstinuisse;"
    val sourceCorpus = Corpus(Vector(CitableNode(urn,txt)))
    val tokenCorpus = Latin23.tokenizedCorpus(sourceCorpus)
    val expectedTokens = 37
    assert(tokenCorpus.size == expectedTokens)
  }

  it should "tokenize a citableNode" in {
    val urn = CtsUrn("urn:cts:omar:stoa0179.stoa001.omar:1.1.1")
    val txt = "iam primum omnium satis constat Troia capta in ceteros saevitum esse Troianos;"
    val cn = CitableNode(urn,txt)
    val tokens = Latin23.tokenizeNode(cn)

    val expectedSize = 13
    assert(tokens.size == expectedSize)

  }
  it should "evaluate valid strings" in {
    assert(Latin23.validString("ius belli"))
  }

  it should "fancy format bad code points in a string" in {
    val hilited = Latin23.hiliteBadCps("latin ανδ greek")
    val expected = "latin  **α**  **ν**  **δ**  greek"
    assert(hilited == expected)
  }

  it should "identify a value for exemplar ID" in {
    assert(Latin23.exemplarId == "lat23tkn")
  }

}
