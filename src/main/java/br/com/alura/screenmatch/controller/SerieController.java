package br.com.alura.screenmatch.controller;

import br.com.alura.screenmatch.dto.EpisodioDTO;
import br.com.alura.screenmatch.dto.SerieDTO;
import br.com.alura.screenmatch.model.Serie;
import br.com.alura.screenmatch.repository.SerieRepository;
import br.com.alura.screenmatch.service.SerieService;
import org.apache.catalina.valves.JsonErrorReportValve;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
@RequestMapping("/series")
@RestController
public class SerieController {

    @Autowired
    private SerieService serieService;

    @GetMapping()
    public List<SerieDTO> obterSeries() {
        return serieService.ObterTodasAsSeries();
    }

    @GetMapping("/top5")
    public List<SerieDTO> obterTop5Series() {
        return serieService.ObterTop5Series();
    }

    @GetMapping("/lancamentos")
     public List<SerieDTO> obterLancamentos() {
        return serieService.obterLancamentos();
    }

    @GetMapping("/{id}")
    public SerieDTO obterPorId(@PathVariable Long id) {
        return serieService.obterSeriePorId(id);
    }

    @GetMapping("/{id}/temporadas/todas")
    public List<EpisodioDTO> obterTodasAsTemporadas(@PathVariable Long id) {
         return serieService.obterTodasAsTemporadas(id);
    }

    @GetMapping("/{id}/temporadas/{num_temporada}")
    public List<EpisodioDTO> obterTemporadasPorNumero(@PathVariable Long id,@PathVariable Long num_temporada) {
        return serieService.obterTemporadaPorNumero(id, num_temporada);

    }

    @GetMapping("/categoria/{nome_categoria}")
    public List<SerieDTO> obterSeriePorCategoria(@PathVariable String nome_categoria) {
        return serieService.obterSeriesPorCategoria(nome_categoria);
    }
}
